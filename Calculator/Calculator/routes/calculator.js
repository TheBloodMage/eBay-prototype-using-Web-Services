/**
 * New node file
 */

var soap = require('soap');
var baseURL = "http://localhost:8080/CalculatorServices/services";

exports.calcOperation = function(req, res) {
	var option = {
		ignoredNamespaces : true
	};
	var url = baseURL + "/calculator?wsdl";
	var args = {
		oprandString : req.param("oprandString")
	};
	soap.createClient(url, option, function(err, client) {
		client.calcOperation(args, function(err, result) {
			var answer = result.calcOperationReturn.$value;
			console.log(answer);

			var json_responses = {
				"answer" : answer
			};

			if (result.validateReturn === true) {
				res.send({
					statusCode : 200
				});
			} else {
				res.send(json_responses);
			}
		});
	});
};

/*
 * exports.calcOperation = function(req, res) { var oprandString =
 * req.param("oprandString"); var json_response; var answer =
 * eval(oprandString);
 * 
 * json_responses = { "answer" : answer };
 * 
 * res.send(json_responses); };
 */