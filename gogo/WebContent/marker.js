function asd() {
    let storeMenu = document.getElementsByClassName("storeMenus");

    fetch("http://localhost:8080/gonggongyung/gogo/gasstation/", { // 누르면 가라
    }).then((response) => response.json())
        .then((data) => {
           
           if(storePositions ==""){ 
            for (let i = 0; i < data.length; i += 2) {
                storePositions.push(new kakao.maps.LatLng(data[i], data[i + 1]));
               
            }
           }
        
        })
    
    createStoreMarkers();
}
  
  
  
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


        function removeMarker() {
            for (var i = 0; i < markers.length; i++) {
                markers[i].setMap(null);
            }
            markers = [];
        }