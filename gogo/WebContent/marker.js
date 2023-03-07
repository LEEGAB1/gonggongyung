









    let gasstation = [];
    let parkinglot = [];
    window.addEventListener("load", function (e) {


        fetch("http://localhost:8080/gonggongyung/gogo/gasstation/", {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then(response => response.json())
            .then(data => {
                for (let i = 0; i < data.length; i++) {
                    gasstation.push(data[i]);
                }

                console.log(data); // 데이터 출력
            });

        fetch("http://localhost:8080/gonggongyung/gogo/parkinglot/", {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then(response => response.json())
            .then(data => {

                for (let i = 0; i < data.length; i++) {
                    parkinglot.push(data[i]);
                }

                console.log(data); // 데이터 출력
            });
    }); //스크립트---------------------










    // 커피숍 마커가 표시될 좌표 배열입니다
    var coffeePositions = [
       
    ];

    // 편의점 마커가 표시될 좌표 배열입니다

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

    var storePositions = [
    ];


    // 주차장 마커가 표시될 좌표 배열입니다
    var carparkPositions = [
        new kakao.maps.LatLng(35.213725, 129.080538),
        new kakao.maps.LatLng(35.162218, 128.986650),
        new kakao.maps.LatLng(35.207310, 129.078527),
        new kakao.maps.LatLng(35.218925, 129.085617),
        new kakao.maps.LatLng(35.228187, 129.089228),
        new kakao.maps.LatLng(35.231583, 129.089107),
        new kakao.maps.LatLng(35.239165, 129.088416),
        new kakao.maps.LatLng(35.245568, 129.091272),
        new kakao.maps.LatLng(35.271787, 129.086944),
        new kakao.maps.LatLng(35.283211, 129.095100),
        new kakao.maps.LatLng(35.104432, 128.964301),
        new kakao.maps.LatLng(35.148665, 129.001262),
        new kakao.maps.LatLng(35.169164, 129.177395),
        new kakao.maps.LatLng(35.158553, 129.157447),
        new kakao.maps.LatLng(35.154860, 129.131361),
        new kakao.maps.LatLng(35.156248, 129.133637),
        new kakao.maps.LatLng(35.167034, 129.170428),
        new kakao.maps.LatLng(35.157361, 129.151082),
        new kakao.maps.LatLng(35.202879, 129.131858),
        new kakao.maps.LatLng(35.176877, 129.126678),
        new kakao.maps.LatLng(35.236981, 129.016439),
        new kakao.maps.LatLng(35.173494, 129.173747),
        new kakao.maps.LatLng(35.167026, 129.170446),
        new kakao.maps.LatLng(35.167749, 129.175966),
        new kakao.maps.LatLng(35.080702, 129.046095),
        new kakao.maps.LatLng(35.112920, 129.027845),
        new kakao.maps.LatLng(35.167635, 129.178492),
        new kakao.maps.LatLng(35.116586, 129.020095),
        new kakao.maps.LatLng(35.161695, 129.170300),
        new kakao.maps.LatLng(35.220937, 129.146448),
    ];

    var markerImageSrc = 'https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FczwJDf%2Fbtr0aQQF3K0%2FAsphV4K9VzNi3sKyOLJXRK%2Fimg.png';  // 마커이미지의 주소입니다. 스프라이트 이미지 입니다
    coffeeMarkers = [], // 커피숍 마커 객체를 가지고 있을 배열입니다
        storeMarkers = [], // 편의점 마커 객체를 가지고 있을 배열입니다
        carparkMarkers = []; // 주차장 마커 객체를 가지고 있을 배열입니다


    createCoffeeMarkers(); // 커피숍 마커를 생성하고 커피숍 마커 배열에 추가합니다
    createStoreMarkers(); // 편의점 마커를 생성하고 편의점 마커 배열에 추가합니다
    createCarparkMarkers(); // 주차장 마커를 생성하고 주차장 마커 배열에 추가합니다

    changeMarker(''); // 지도에 커피숍 마커가 보이도록 설정합니다    


    // 마커이미지의 주소와, 크기, 옵션으로 마커 이미지를 생성하여 리턴하는 함수입니다
    function createMarkerImage(src, size, options) {
        var markerImage = new kakao.maps.MarkerImage(src, size, options);
        return markerImage;
    }

    // 좌표와 마커이미지를 받아 마커를 생성하여 리턴하는 함수입니다
    function createMarker(position, image) {
        var marker = new kakao.maps.Marker({
            position: position,
            image: image
        });

        return marker;
    }

    // 커피숍 마커를 생성하고 커피숍 마커 배열에 추가하는 함수입니다
    function createCoffeeMarkers() {

        for (var i = 0; i < coffeePositions.length; i++) {

            var imageSize = new kakao.maps.Size(22, 26),
                imageOptions = {
                    spriteOrigin: new kakao.maps.Point(10, 0),
                    spriteSize: new kakao.maps.Size(36, 98)
                };

            // 마커이미지와 마커를 생성합니다
            var markerImage = createMarkerImage(markerImageSrc, imageSize, imageOptions),
                marker = createMarker(coffeePositions[i], markerImage);

            // 생성된 마커를 커피숍 마커 배열에 추가합니다
            coffeeMarkers.push(marker);
        }
    }

    // 커피숍 마커들의 지도 표시 여부를 설정하는 함수입니다
    function setCoffeeMarkers(map) {
        for (var i = 0; i < coffeeMarkers.length; i++) {
            coffeeMarkers[i].setMap(map);
        }
    }

    // 편의점 마커를 생성하고 편의점 마커 배열에 추가하는 함수입니다
    function createStoreMarkers() {
        for (var i = 0; i < storePositions.length; i++) {

            var imageSize = new kakao.maps.Size(22, 26),
                imageOptions = {
                    spriteOrigin: new kakao.maps.Point(10, 0),
                    spriteSize: new kakao.maps.Size(36, 98)
                };

            // 마커이미지와 마커를 생성합니다
            var markerImage = createMarkerImage(markerImageSrc, imageSize, imageOptions),
                marker = createMarker(storePositions[i], markerImage);

            // 생성된 마커를 편의점 마커 배열에 추가합니다
            storeMarkers.push(marker);
        }
    }

    // 편의점 마커들의 지도 표시 여부를 설정하는 함수입니다
    function setStoreMarkers(map) {
        for (var i = 0; i < storeMarkers.length; i++) {
            storeMarkers[i].setMap(map);
        }
    }

    // 주차장 마커를 생성하고 주차장 마커 배열에 추가하는 함수입니다
    function createCarparkMarkers() {
        for (var i = 0; i < carparkPositions.length; i++) {

            var imageSize = new kakao.maps.Size(22, 26),
                imageOptions = {
                    spriteOrigin: new kakao.maps.Point(10, 72),
                    spriteSize: new kakao.maps.Size(36, 98)
                };

            // 마커이미지와 마커를 생성합니다
            var markerImage = createMarkerImage(markerImageSrc, imageSize, imageOptions),
                marker = createMarker(carparkPositions[i], markerImage);

            // 생성된 마커를 주차장 마커 배열에 추가합니다
            carparkMarkers.push(marker);
        }
    }

    // 주차장 마커들의 지도 표시 여부를 설정하는 함수입니다
    function setCarparkMarkers(map) {
        for (var i = 0; i < carparkMarkers.length; i++) {
            carparkMarkers[i].setMap(map);
        }
    }

    // 카테고리를 클릭했을 때 type에 따라 카테고리의 스타일과 지도에 표시되는 마커를 변경합니다
    function changeMarker(type) {

        var coffeeMenu = document.getElementById('coffeeMenu');
        var storeMenu = document.getElementById('storeMenu');
        var carparkMenu = document.getElementById('carparkMenu');

        // 커피숍 카테고리가 클릭됐을 때
        if (type === 'coffee') {

            // 커피숍 카테고리를 선택된 스타일로 변경하고
            coffeeMenu.className = 'menu_selected';

            // 편의점과 주차장 카테고리는 선택되지 않은 스타일로 바꿉니다
            storeMenu.className = '';
            carparkMenu.className = '';

            // 커피숍 마커들만 지도에 표시하도록 설정합니다
            setCoffeeMarkers(map);
            setStoreMarkers(null);
            setCarparkMarkers(null);

        } else if (type === 'store') { // 편의점 카테고리가 클릭됐을 때

            // 편의점 카테고리를 선택된 스타일로 변경하고
            coffeeMenu.className = '';
            storeMenu.className = 'menu_selected';
            carparkMenu.className = '';

            // 편의점 마커들만 지도에 표시하도록 설정합니다
            setCoffeeMarkers(null);
            setStoreMarkers(map);
            setCarparkMarkers(null);

        } else if (type === 'carpark') { // 주차장 카테고리가 클릭됐을 때

            // 주차장 카테고리를 선택된 스타일로 변경하고
            coffeeMenu.className = '';
            storeMenu.className = '';
            carparkMenu.className = 'menu_selected';

            // 주차장 마커들만 지도에 표시하도록 설정합니다
            setCoffeeMarkers(null);
            setStoreMarkers(null);
            setCarparkMarkers(map);
        }
    }

    window.onload = function () {
}