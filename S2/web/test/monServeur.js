var http = require('http');
var url = require('url');
var fs = require('fs');
var dt = require('./monModule');

http.createServer(function (req, res) {

	fs.readFile('test.html', function(err, data) {

		res.writeHead(200, {'Content-Type': 'text/html'});
		res.write(data);
		res.write("The date and time are currently: " + dt.myDateTime());
		res.write("<br>")

		var q = url.parse(req.url, true).query;
		var txt = q.annee + " " + q.mois;
		res.write(txt);
		res.write("<br>")
		res.end();
	});
    
}).listen(8888);
