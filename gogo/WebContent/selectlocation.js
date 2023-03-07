
window.onload = function () {
    let guSelect = document.getElementById("guSelect");
    let dongSelect = document.getElementById("dongSelect");
    let selectlocation = document.getElementById("selectlocation");
    let region = document.getElementById("region");
    let placesList = document.getElementById("placesList");
    let zone = document.getElementById("zone");

    let menuEl = document.getElementById('menu_wrap'),
        fragment = document.createDocumentFragment(),

        listStr = '';
    selectlocation.addEventListener("click", function (e) {
        const regionform = new FormData(region);
        regionform.append("guSelect", guSelect.value);
        regionform.append("dongSelect", dongSelect.value);
        fetch("http://localhost:8080/gonggongyung/gogo/gasstation", {
            method: "POST",
            body: new URLSearchParams([...regionform.entries()]), // post body형식
            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
            }
        }).then((resp) => {

            return resp.json();
        }).then((obj) => {
            if (obj != "") {
                removeMarker();
                removeAllChildNods(placesList);
                bounds = new kakao.maps.LatLngBounds();
                for (let i = 0; i < obj.length; i++) {
                    let myobj = {};
                    myobj.diesel = obj[i].diesel
                    myobj.gasoline = obj[i].gasoline
                    myobj.p_gasoline = obj[i].p_gasoline
                    myobj.region = obj[i].region
                    myobj.self = obj[i].self
                    myobj.storeaddress = obj[i].storeaddress
                    myobj.storebrand = obj[i].storebrand
                    myobj.storename = obj[i].storename
                    myobj.storenumber = obj[i].storenumber
                    myobj.x = obj[i].x
                    myobj.y = obj[i].y

                    function getListItem(index, myobj) {
                        var el = document.createElement('li');
                        itemStr = '<span class="markerbg marker_' + (index + 1) + '"></span>' +
                        '<div class="info", onclick="toggleSidebar(' + index + '),chartclear(),showchart(),setOilType(diesel),reviewlist()">' +
                            '   <h4><p id="name' + index + '" class="innerbutton">' + myobj.storename + '</p></h4>';
                        if (myobj) {
                            itemStr += '    <span>' + myobj.storebrand + '</span>' +
                                '   <span class="jibun gray">' + myobj.storeaddress + '</span>';
                        } else {
                            itemStr += '    <span>' + myobj.storenumber + '</span>';
                        }
                        itemStr += '  <span class="tel">' + myobj.region + '</span>' +
                            '</div>';
                        el.innerHTML = itemStr;
                        el.className = 'item';
                        return el;
                    }
                    var placePosition = new kakao.maps.LatLng(obj[i].x, obj[i].y);
                    marker = addMarker(placePosition, i);
                    itemEl = getListItem(i, obj[i]); // 검색 결과 항목 Element를 생성합니다
                    // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
                    // LatLngBounds 객체에 좌표를 추가합니다
                    bounds.extend(placePosition);
                    fragment.appendChild(itemEl);

                }
                placesList.appendChild(fragment); //??
                menuEl.scrollTop = 0;
                map.setBounds(bounds);
            }
            else {
                console.log("실행");
                removeAllChildNods(placesList);
                placesList.innerText = "검색 내용이 없습니다";
            }
        })
    });
}