// This is a simple *viewmodel* - JavaScript that defines the data and behavior of your UI
function AppViewModel() {
    this.email = ko.observable("bclarance@gmail.com");
    this.firstName = ko.observable("Bilal");
    this.lastName = ko.observable("Clarance");


    this.fullName = ko.computed(function() {
        return this.firstName() + " " + this.lastName();
    }, this);
}

// Activates knockout.js
$(function() {
    ko.applyBindings(new AppViewModel());
});