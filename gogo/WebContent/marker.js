window.onload = function(){
function asd() {
    let storeMenu = document.getElementsByClassName("storeMenus");

    fetch("http://localhost:8080/gonggongyung/gogo/gasstation/", { // 누르면 가라
    }).then((response) => response.json())
        .then((data) => {
            for (let i = 0; i < data.length; i += 2) {
                storePositions.push(new kakao.maps.LatLng(data[i], data[i + 1]));
                console.log(storePositions);
            }
        })
    createStoreMarkers();
}
}