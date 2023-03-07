// ------------사이드바함수------------
        
function toggleSidebar(index) {
    let namebtn = document.getElementById("namebtn");
    let name = document.getElementById("name" + index);
    namebtn.innerHTML = name.innerHTML;
    
    let todayDiesel = document.getElementById("diesel");
    let todayGasoline = document.getElementById("gasoline");
    let gasRegion = document.getElementById("gasRegion");
    let priceNum = document.getElementById("priceNum");
    let storename = namebtn.innerText;
    
    if(name){
        fetch("http://localhost:8080/gonggongyung/gogo/gasstation?type=diesel&name=" + storename)
        .then((resp) => resp.json())
        .then((obj) => {
            gasRegion.innerText = obj.region;
            priceNum.innerText = obj.pricenum;
            todayDiesel.innerText = obj.dieselprice + "원";
            todayGasoline.innerText = obj.gasolineprice + "원";
            })
            .catch((e) => console.log(e))
            
            gasRegion.innerText = "~";
            priceNum.innerText = "~";
            todayDiesel.innerText = "~";
            todayGasoline.innerText = "~";
        }

    var before = document.getElementsByClassName("active")[0] // 창 실시간 변동현황
    if (before && document.getElementsByClassName("active")[0] != index) {
        // before.nextElementSibling.style.maxHeight = null;
        before.classList.remove("active");
    }
    document.querySelector('.sidebar').classList.toggle('active');

    

}

function closeSidebar() {
    document.querySelector('.sidebar').classList.toggle('active');

}