
var models = {};
 
models.Account = Backbone.Model.extend({
	defaults : {
		id: ''
		,pwd: ''
		,name: ''
		,email: ''
		,regdate: ''
	},

	validate: function(attributes) {
		if (typeof attributes.id !== 'string') {
			return 'id is mandatory';
		}
		if (typeof attributes.pwd !== 'string') {
			return 'pwd is mandatory';
		}
	}
});
 
// Users collection
models.Users = Backbone.Collection.extend({
	url: "/account/selectAccountList"
	,model: models.Account
	,initialize: function () {
	}
	,Loading: false
	,getRefreshData: function () {
		if (!this.Loading) {
			this.Loading = true;
			this.fetch({
				//data: JSON.stringify({'id':'jrkang','pwd':'jrkang'}),
				data: '',
				type:        'POST',
				dataType:    'json',
				contentType: 'application/json',
				cache:       false,
				success:     this.success,
				error:       this.error
			});
		}
	}
	,success: function(data, response) {
		var json = JSON.stringify(data);
		console.log("success = "+json);
	}
	,error: function(error){
		console.log("error = "+error);
	}
});
