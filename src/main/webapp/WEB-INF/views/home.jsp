<html>
<style type="text/css">
body {
    font-family: Arial, Helvetica;
    }
#outer {
    background-color:#aaa;
    position:absolute;
    top:0px;
    left:0px;
    height:100%;
    width:100%; 
}

#inner {
    position:relative;
    margin-left:auto;
    margin-right:auto;
    margin-top:10px;
    width:800px;
    height:500px;
    background-color:#eee;
    border:1px solid #666;
    box-shadow: .1em .1em .2em #666;
    padding-left:50px;
    padding-right:50px;
}
#inner h2 {

    text-align:center;
}
#nameEntry, #addressEntry, #phoneEntry, #emailEntry {
    font-weight:bold;
    position:relative;
    left:50px;
    margin-top:30px;
}
#nameField, #addressField, #phoneField, #emailField {
    position:relative;
    left:100px;
    top:-20px;
    width:300px;
}
#listEntry{
    position:absolute;
    right:50px;
    top:90px;
    width:300px;
}
#addressList {
    background-color:white;
    width:300px;
    height:250px;
}
#saveEntry{
    position:absolute;
    bottom:50px;
    left:300px;
}
#saveButton,#deleteButton{
    width:100px;
}
#deleteEntry{
    position:absolute;
    bottom:50px;
    right:50px;
}
</style>
<head>
    <title>Granny's Addressbook</title>

<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"> </script>

</head>
<body>
<div id="outer">
<div id="inner">
<h2>
    Granny's Addressbook
</h2>

<div id="content">
    <form id="addressForm" name="addressForm">
        <input id="selectedIndexField" name="selectedIndex" type="hidden" value=""/>
        <input id="oldNameField" name="oldName" type="hidden" value=""/>
        <div id="nameEntry">
            <div id="nameLabel" class="label">Name</div><input id="nameField" name="name" type="text" value=""/>
        </div>
        <div id="addressEntry">
            <div id="addressLabel" class="label">Address</div><input id="addressField" name="address" type="text" value=""/>
        </div>  
        <div id="phoneEntry">
            <div id="phoneLabel" class="label">Phone</div><input id="phoneField" name="phone" type="text" value=""/>
        </div>   
        <div id="emailEntry">
            <div id="emailLabel" class="label">Email</div><input id="emailField" name="email" type="text" value=""/>
        </div>
        <div id="saveEntry">
            <input id="saveButton" value="Save" type="button" onClick="app.saveAddress()"/>
        </div>  
        <div id="listEntry"> 
            <div id="list">
                <select size="10" id="addressList" name="addressList">                  
                </select>
            </div>
        </div>
        <div id="deleteEntry">
            <input id="deleteButton" value="Delete" onClick="app.deleteAddress()" type="button"/>
        </div>  
    </form>

</div><!-- end content-->
</div><!-- end inner -->
</div><!-- end outer -->
<script type="text/javascript">
//create an object to store our functions and variables

var app = {
     //populate the list box
    getAllAddresses: function () {
        $.getJSON("addresses", function(data){
            // data = data.data;
            
            var entries = [];
            entries.push("<option value='' />");
            $.each(data, function(){
                entries.push("<option name='"+ this.name + "' value='"+ this._id+"'>"+ this.name +"</option>");
            });
            
            $("#addressList").empty();
            $(entries.join("")).appendTo("#addressList");
        });
        
    },
     //save addresses
    saveAddress: function(){
        var address = app.makeAddress();
        if(address._id === "" || address._id.length <1) { app.createAddress(address); return;}
        $.ajax({
            url:"update",
            type:"put",
            contentType:"application/json",
            processData: false,
            data: JSON.stringify(address),
            success: function() { app.getAllAddresses(); }
        });
        
    },
    createAddress: function(address) {
//          delete address._id;
          $.ajax({
                  url:"create",
                  type:"post",
                  contentType:"application/json",
                  processData: false,
                  data: JSON.stringify(address),
                  success: function() { app.getAllAddresses(); }
           });
    },
    makeAddress: function(){
        var addressObject = {
        	_id: $("#selectedIndexField").attr("value"),
        	name: $("#nameField").attr("value"),
            address: $("#addressField").attr("value"),
            phone: $("#phoneField").attr("value"),
            email: $("#emailField").attr("value")           
        };
        return addressObject;
     }, 
    emptyUser: {
    		_id:"",
            name: "",
            address: "",
            phone: "",
            email: ""
    },
    getAddressById: function (id){
        if(id){
             $.ajax({
                 url:"get/"+id,
                 type:"get",
                 success: function(data) { app.populateFields(data); }
             });
        }
        else{
            app.populateFields(app.emptyUser);
            
        }
    },
    
    populateFields: function(addressJSON){
        $("#nameField").attr("value", addressJSON.name);
        $("#addressField").attr("value", addressJSON.address);
        $("#phoneField").attr("value", addressJSON.phone);
        $("#emailField").attr("value", addressJSON.email);
        $("#selectedIndexField").val(addressJSON._id || "");
    },
    
    deleteAddress: function(){
        var address = app.makeAddress();
     // var currentName = $("#nameField").attr("value");
        $.ajax({
            url:"delete",
            type:"delete",
            contentType:"application/json",
            data: JSON.stringify(address),
            success: function() {
                app.getAllAddresses();
                app.populateFields(app.emptyUser);
            }
        });
    }


};

//after the page loads
$(function () {
    app.getAllAddresses();
    $("#addressList").on("click","option", function(){ app.getAddressById(this.value); });
});
</script>
</body>
</html>

