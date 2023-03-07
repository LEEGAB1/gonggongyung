// 줌 컨트롤


        // 마커가 지도 위에 표시되도록 설정합니다
        marker.setMap(map);

        // 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
        kakao.maps.event.addListener(map, 'ZoomControl', function () {

            // 지도의  레벨을 얻어옵니다
            var level = map.getLevel();

            // 지도의 중심좌표를 얻어옵니다 
            var latlng = map.getCenter();

            var message = '<p>지도 레벨은 ' + level + ' 이고</p>';
            message += '<p>중심 좌표는 위도 ' + latlng.getLat() + ', 경도 ' + latlng.getLng() + '입니다</p>';

            var resultDiv = document.getElementById('result');
            resultDiv.innerHTML = message;
            // 지도를 표시하는 div 크기를 변경하는 함수입니다
            function resizeMap() {
                var mapContainer = document.getElementById('map');
                mapContainer.style.width = 'full';
                mapContainer.style.height = 'full';
            }


            // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
            var mapTypeControl = new kakao.maps.MapTypeControl();

            // 지도 타입 컨트롤을 지도에 표시합니다
            map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);




            function getInfo() {
                // 지도의 현재 중심좌표를 얻어옵니다 
                var center = map.getCenter();

                // 지도의 현재 레벨을 얻어옵니다
                var level = map.getLevel();

                // 지도타입을 얻어옵니다
                var mapTypeId = map.getMapTypeId();

                // 지도의 현재 영역을 얻어옵니다 
                var bounds = map.getBounds();

                // 영역의 남서쪽 좌표를 얻어옵니다 
                var swLatLng = bounds.getSouthWest();

                // 영역의 북동쪽 좌표를 얻어옵니다 
                var neLatLng = bounds.getNorthEast();

                // 영역정보를 문자열로 얻어옵니다. ((남,서), (북,동)) 형식입니다
                var boundsStr = bounds.toString();


                // var message = '지도 중심좌표는 위도 ' + center.getLat() + ', <br>';
                // message += '경도 ' + center.getLng() + ' 이고 <br>';
                // message += '지도 레벨은 ' + level + ' 입니다 <br> <br>';
                // message += '지도 타입은 ' + mapTypeId + ' 이고 <br> ';
                // message += '지도의 남서쪽 좌표는 ' + swLatLng.getLat() + ', ' + swLatLng.getLng() + ' 이고 <br>';
                // message += '북동쪽 좌표는 ' + neLatLng.getLat() + ', ' + neLatLng.getLng() + ' 입니다';



                // 개발자도구를 통해 직접 message 내용을 확인해 보세요.
                // ex) console.log(message);
            }
            // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
            var zoomControl = new kakao.maps.ZoomControl();
            map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

        });




