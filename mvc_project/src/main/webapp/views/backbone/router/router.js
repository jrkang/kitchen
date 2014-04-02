
var Router = Backbone.Router.extend({
	routes: {
		'': 'index'  // At first we display the index route
	},

	index: function() {
	// Initialize a list of people
	// In this case we provide an array, but normally you'd
	// instantiate an empty list and call people.fetch()
	// to get the data from your backend
		var users = new models.Users([
		{
			id: 'admin'
			,pwd: 'no1ids'
			,name: 'administrator'
			,email: 'admin@korea.com'
			,regdate: '2014-03-19 10:30:15'
		},
		{
			id: 'jrkang'
			,pwd: 'jrkang'
			,name: 'jrkang'
			,email: 'jrkang@korea.com'
			,regdate: '2014-03-28 09:53:16'
		}
		]);

    // Pass the collection of users to the view
		var view = new views.Users({
			collection: users
		});
 
    // And render it
		view.render();
 
    // Example of adding a new account afterwards
    // This will fire the 'add' event in the collection
    // which causes the view to re-render
		users.add([
		{
			id: 'infojr'
			,pwd: 'infojr'
			,name: 'infojr'
			,email: 'infojr@korea.com'
			,regdate: '2014-03-27 09:53:16'
		}
		]);
	}
});
 
jQuery(document).ready(function() {
  // When the document is ready we instantiate the router
	var router = new Router();
 
  // And tell Backbone to start routing
	Backbone.history.start();
});