$(function(){
 Person = Backbone.Model.extend({
	initialize: function(){
	},
	defaults: {
    id: "1",		
		name: "Gambeiro",
		rank: "24",
		badges: 'cooker' 
	}


});

 window.PersonList = Backbone.Collection.extend({
 	model: Person
 });

 var p1 = new Person({id: "1", name: "toto", rank: "11", badges: "cooker"});
 var p2 = new Person({id: "2", name: "toto2", rank: "12", badges: "cowboy"});
 window.Persons = new PersonList([p1, p2]);

 PersonView = Backbone.View.extend({
	el: $('#gambeiros'),
	initialize: function(){
		Persons.bind('change', this.render, this);
		Persons.bind('all', this.render, this);
	},
	
	render: function(){
		var html = '';
		Persons.each(function(p){
			html = html + '<tr>';
			html = html + '<td>' + p.get('name') + '</td>';
			html = html + "<td>" + p.get('rank') + "</td>";
			html = html + '<td><img src="images/' + p.get('badges') + '.png" /></td>';
			html = html + '</tr>';
		});
		this.$el.html(html);
		return this;
	}
 });

//var person = new Person();
//person.set({name: "teste", age: "26"});
window.App = new PersonView;
window.App.render();
});
