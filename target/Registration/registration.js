var handlers = {};
handlers.agreeTermsAndConditionsOnChange = function() {
	console.log("Check box value modified");
	if ($(this).prop("checked")) {
		$('#signup').show();
	} else {

		$('#signup').hide();
	}
};
i = 0;
$(document).ready(function() {
	$('#okemail').hide();
	$('#nookemail').hide();
	$('#email').keyup(function() {
		$.ajax({
			url : "ExistingUserEmail",
			data : {
				email : $('#email').val()
			},
			success : function(data) {
				
				if (data == 12) {
					$('#nookemail').show();
					$('#okemail').hide();
					$('#signup').hide();
				} else if (data == 13) {
					$('#okemail').show();
					$('#nookemail').hide();
					$('#signup').show();
				}

			}
		})

	});
});

handlers.extractInfo = function() {
	$('#sinfoname').text($('#name').val())
	$('#sinfoemail').text($('#email').val())
	$('#sinfocontact').text($('#contact').val())
	$('#sinfocountrylist').text($('#country').val())
	$('#sinfoarea').text($('#area').val())
	$('#sinfocity').text($('#city').val())
	$('#sinfostreet').text($('#street').val())
	$('#sinfodistrict').text($('#dist').val())
	$('#sinfobloodgroup').text($('#blood_group').val())
};

handlers.getStates = function() {
	$.getJSON('country', {
		name : $('#country').val()
	}, function(data) {
		var $city = $("#city");
		// Clear existing options
		$city.empty();
		// Populate the options
		$.each(data.City, function(index, city) {
			$city.append(new Option(city, city));
		});
	});
};

var kon = function() {
	var self = this;
	self.countriesList = ko.observableArray([ {
		id : 'IND',
		value : "IND"
	}, {
		id : 'CHN',
		value : "CHN"
	}, {
		id : 'BRA',
		value : "BRA"
	}, {
		id : 'FRA',
		value : "FRA"
	}, {
		id : 'USA',
		value : "USA"
	} ]);
	self.name = ko.observable("");
	self.email = ko.observable("");
	self.contact = ko.observable("");
	self.bloodgroup = ko.observable("");
	self.country = ko.observable("IND");
	self.city = ko.observable("");
	self.area = ko.observable("");
	self.street = ko.observable("");
	self.district = ko.observable("");
	self.statesList = ko.observableArray();
	self.getStates = ko.computed(function() {
		var country = self.country();
		$.getJSON('country', {
			name : country
		}, function(data) {
			// Populate the options
			self.statesList.removeAll();
			$.each(data.City, function(index, city) {
				self.statesList.push(city);
			});
		});
	});
};

$(document).ready(function() {

	var viewModel = new kon();
	ko.applyBindings(viewModel);
	// Register handler for Checkbox
	$("#agree").change(handlers.agreeTermsAndConditionsOnChange);
	$('#info').click(handlers.extractInfo);
	// $("#country").change(handlers.getStates);
	$("form").submit(function(e) {
		// e.preventDefault();
		console.log("Form was submitted");
	});
	$('#signup').hide();
});
$(document).ready(function() {
	$('#form').validate();
});