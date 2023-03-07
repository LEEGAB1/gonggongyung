function getCurrentPos() {
    navigator.geolocation.getCurrentPosition(function (position) {
        var mapContainer = document.getElementById('map'); // 지도를 표시할 div 
        let lat = 35.15959895331954;
        let lon = 129.0601078522617;
        // var lat = position.coords.latitude, // 위도
        //     lon = position.coords.longitude; // 경도
        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
            message = '<div style="height: 25px; padding:2px 8px; m argin: 3px;">메롱~~~~~~~~~</div>'    // 인포윈도우에 표시될 내용입니다

        displayMarker(locPosition, message, mapOption);

        map.setLevel(2);
    });
    // 지도에 마커와 인포윈도우를 표시하는 함수입니다
    function displayMarker(locPosition, message) { // 마커를 생성합니다
        var imageSrc_loc = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FkKkSb%2FbtrZBswymE9%2FNeYXXnsq79d4Mk6vEl3gKk%2Fimg.png";
        var imageSize_loc = new kakao.maps.Size(120, 120); // 마커 이미지 생성
        var markerImage_loc = new kakao.maps.MarkerImage(imageSrc_loc, imageSize_loc);
        var marker_loc = new kakao.maps.Marker({
            map: map,
            position: locPosition,
            image: markerImage_loc

        });
        var iwContent = message, // 인포윈도우에 표시할 내용
            iwRemoveable = true;
        // 인포윈도우를 생성합니다
        var infowindow = new kakao.maps.InfoWindow({ content: iwContent });
        // 인포윈도우를 마커위에 표시합니다
        infowindow.open(map, marker_loc);
        // 지도 중심좌표를 접속위치로 변경합니다
        map.setCenter(locPosition);
    }
};