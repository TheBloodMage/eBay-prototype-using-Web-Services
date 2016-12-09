//loading the 'calculator' angularJS module
var calculator = angular.module('calculator', []);

calculator.controller('calculator', function($scope, $http) {
	
	var oprandString = "";
	
	$scope.updateAnswer = function(oprand) {
		oprandString += oprand;
		$scope.output = oprandString
		
	}
	
	$scope.clearScreen = function() {
		oprandString = "";
		$scope.calculationString = "";
		$scope.output = "";
	}
	
	$scope.giveAnswer = function() {
		
		var answer = {
				"oprandString" : oprandString
		}
		
		$http({
			method : "POST",
			url : '/calcOperation',
			data : answer
		}).success(function(data) {
			$scope.calculationString = data.answer;
			oprandString = "";
		})
	}
	

})
