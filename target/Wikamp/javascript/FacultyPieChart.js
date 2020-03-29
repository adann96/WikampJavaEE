$(document).ready(function(){
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    var facultyStats = [];

    var table = document.getElementsByTagName("table")[0];
    table.bgColor = "Yellow";

    var td = table.getElementsByTagName("td");

    for (var i = 0; i < td.length; i++) {
        if (i % 2 == 0) {
            facultyStats[i] = td[i].innerHTML.trim();
            td[i].style.background = "LightBlue";
        }
        else {
            facultyStats[i] = td[i];
            td[i].style.background = "Orange";
        }
    }

    function drawChart() {

        var data = google.visualization.arrayToDataTable([
            ['Task', 'Hours per Day'],
            [facultyStats[0].toString(), parseInt(facultyStats[1].innerHTML.trim(), 10)],
            [facultyStats[2].toString(), parseInt(facultyStats[3].innerHTML.trim(), 10)],
            [facultyStats[4].toString(), parseInt(facultyStats[5].innerHTML.trim(), 10)],
            [facultyStats[6].toString(), parseInt(facultyStats[7].innerHTML.trim(), 10)],
            [facultyStats[8].toString(), parseInt(facultyStats[9].innerHTML.trim(), 10)],
            [facultyStats[10].toString(), parseInt(facultyStats[11].innerHTML.trim(), 10)],
            [facultyStats[12].toString(), parseInt(facultyStats[13].innerHTML.trim(), 10)],
            [facultyStats[14].toString(), parseInt(facultyStats[15].innerHTML.trim(), 10)],
        ]);

        var options = {
            title: 'Number of students per faculty (in %)'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
    }
});