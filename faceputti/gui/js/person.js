$(function(){
 Person = Backbone.Model.extend({
	initialize: function(){
	},
	defaults: {
    id: "1",		
		name: "Gambeiro",
		rank: "24",
		badges: []
	}

});

 PersonView = Backbone.View.extend({
	el: $('#name'),
	model: new Person,
	initialize: function(){
		this.model.bind('change', this.render, this);
	},
	
	render: function(){
						console.log("I passed here :p");
		this.$el.html(this.model.get('name'));
		return this;
	}
 });

//var person = new Person();
//person.set({name: "teste", age: "26"});
window.App = new PersonView;
window.App.render();
});
