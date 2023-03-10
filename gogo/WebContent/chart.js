//================================chart========================================
var chart;

function showchart() {
    const ctx = document.getElementById('myChart');
    let storename = namebtn.innerText;
    
    fetch("http://192.168.0.103:8080/gonggongyung/gogo/gasstation?type=diesel&name=" + storename)
    .then((resp) => resp.json())
    .then((obj) => {
        let oneweekprice = [];
        for(let i = 0; i < obj.oneweek.length; i++) {
                oneweekprice.push(obj.oneweek[i]);
            }
            console.log(oneweekprice)
            
            chart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: [dateCalculator(-6), dateCalculator(-5), dateCalculator(-4), dateCalculator(-3), dateCalculator(-2), dateCalculator(-1), dateCalculator(0)],

                    datasets: [{
                        label: 'diesel',
                        data: [oneweekprice[6]
                                , oneweekprice[5]
                                , oneweekprice[4]
                                , oneweekprice[3]
                                , oneweekprice[2]
                                , oneweekprice[1]
                                , oneweekprice[0]],
                        borderWidth: 2, 
                        borderColor: '#160d69',
                        backgroundColor : '#9BBBDF',
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
    })
    .catch((e) => console.log(e))
    
}

function dateCalculator(n) {
    let today = new Date();
    let newday = new Date(today.setDate(today.getDate() + n));
    let newmonth = newday.getMonth() + 1
    let newdate = newday.getDate();
    return newmonth + "/" + newdate;
}

function chartclear() {
    if(chart){
        chart.destroy();
    }
}