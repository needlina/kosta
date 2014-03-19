/** */
var playerWeapon;
var comWeapon;
var arr = [1,2,3,4,5];
reply_click.count = 1;
attackButtonClick.count=1;

window.onload = function init() {
	shuffleComWeapons();
	startButtionClick();
	weaponButtonClick();	
	attackButtonClick();
	restartButtonClick();
	closeButtonClick();
	
	Array.prototype.shuffle = function(){ 
		 if(this instanceof Array) {
			 var len = this.length;
				if(len == 1) return this;
			 var i = len * 2;
		  while(i > 0) {
		   var idx1 = Math.floor(Math.random()* len);
		   var idx2 = Math.floor(Math.random()* len);
		   if(idx1 == idx2) continue;
		   var temp = this[idx1];
		   this[idx1] = this[idx2];
		   this[idx2] = temp;
		   i--;
		   }
		 } else {
		  alert("No Array Object");
		  } 
		 	return this;
	}
	
	
}
	 

	// 게임 스타트 //

	
	
	
	function startButtionClick() {
		var btn = document.getElementById("startButton");
		btn.addEventListener("click", function() {
			showChoice();
		});		
	} 
	
 	function showChoice() {
		var main = document.getElementById("main");
		var choiceMenu = document.getElementById("choiceMenu");
		var gameStart = document.getElementById("gameStart");

		main.style.visibility = "hidden";
		choiceMenu.style.visibility = "visible";
		gameStart.style.visibility = "hidden";
		
	} 
	
	// 게임 준비 //

	function weaponButtonClick() {
	
		for (var i = 1; i < 4; i++) {
			var btn = document.getElementById("s" + i);
			btn.addEventListener("click", function() {
				if (reply_click.count > 5) {
					alert('모든 무기를 선택하셨습니다.');
					
					makeComWeapons();
					showConfirm(); 
				}
					this.value;
					pasteButton(this.value);
					document.getElementById("weapon" + reply_click.count).value = this.value;
					reply_click.count++;
					});
		}
	}
	
	function pasteButton(value) {
		var weaponStyle = document.getElementById("weapon" + reply_click.count).style
		switch (value) {
		case "가위":
			weaponStyle.display = "block";
			weaponStyle.background = "url('./img/smallScissorButton.png') no-repeat";
			weaponStyle.border = "#F15F5F";
			break;
		case "바위":
			weaponStyle.display = "block";
			weaponStyle.background = "url('./img/smallRockButton.png') no-repeat";
			weaponStyle.border = "#F15F5F";
			break;
		case "보":
			weaponStyle.display = "block";
			weaponStyle.background = "url('./img/smallPaperButton.png') no-repeat";
			weaponStyle.border = "#F15F5F";
			break;
		}
	}
	
	function reply_click() {
		
	}

	function equipWeapons() { 
		playerWeapon = [];
		for(var i = 1 ;i < 6; i++){
			var weaponStyle = document.getElementById("pW" + i).style;
			playerWeapon.push(document.getElementById("weapon"+i).value);
			document.getElementById("pW"+i).value = playerWeapon[i-1];
			var value = document.getElementById("pW"+i).value;
			switch (value) {
			case "가위":
				weaponStyle.background = "url('./img/smallScissorButton.png') no-repeat";
				weaponStyle.border = "#F15F5F";
				break;
			case "바위":
				weaponStyle.background = "url('./img/smallRockButton.png') no-repeat";
				weaponStyle.border = "#F15F5F";
				break;
			case "보":
				weaponStyle.background = "url('./img/smallPaperButton.png') no-repeat";
				weaponStyle.border = "#F15F5F";
				break;
			}
		}
	}
	

	function showConfirm() {
		var ok = confirm("계속 진행하시겠습니까?");
		if (ok == true) {
			equipWeapons();
			showMain();
		} else {
			alert("다시 선택하세요.");
			location.reload();
		}
	}
	
	function makeComWeapons() {
		comWeapon = [];
		for (var i = 1; i < 6 ; i++) {
			var weaponStyle = document.getElementById("cW" + i).style;
			switch (Math.ceil(Math.random() * 3)){
			case 1:
				comWeapon.push("가위");
				break;
			case 2:
				comWeapon.push("바위");
				break;
			case 3:
				comWeapon.push("보");
				break;
			}
			document.getElementById("cW"+i).value = comWeapon[i-1];
			var value = document.getElementById("cW"+i).value;
			switch (value) {
			case "가위":
				weaponStyle.background = "url('./img/smallScissorButton.png') no-repeat";
				weaponStyle.border = "#F15F5F";
				break;
			case "바위":
				weaponStyle.background = "url('./img/smallRockButton.png') no-repeat";
				weaponStyle.border = "#F15F5F";
				break;
			case "보":
				weaponStyle.background = "url('./img/smallPaperButton.png') no-repeat";
				weaponStyle.border = "#F15F5F";
				break;
			}
		}
	}
	
	function shuffleComWeapons() {
		arr.shuffle();
		var weaponHtml = "";
		for (var i = 1; i < 6; i++) {
			weaponHtml += ('<input id="cW' + arr[i-1] + '" class="comWeapons" type="button" value=""/>');
			// '<option value="'+i+'">'+i+'</option>'
			//optionHtml += ('<option value="#">#</option>'.replace("#",i));
		}
		var vic = '<div id="comVictories"><input id="cv1" class="comVictories" type="button" value=""/><input id="cv2" class="comVictories" type="button" value=""/><input id="cv3" class="comVictories" type="button" value=""/><input id="cv4" class="comVictories" type="button" value=""/><input id="cv5" class="comVictories" type="button" value=""/></div>'

		document.getElementById("com").innerHTML = '<span>com</span><br/>' + weaponHtml + vic + '<input id="selectedComWeapon" type="button" value=""/>';
	}
	
	
	
	
	// 게임 화면
	
	function showMain() {
		var main = document.getElementById("main");
		var choiceMenu = document.getElementById("choiceMenu");
		var gameStart = document.getElementById("gameStart");

		main.style.visibility = "visible";
		choiceMenu.style.visibility = "hidden";
		gameStart.style.visibility = "hidden";
		
	}
	
	// 게임 로직
	function judge(pW, cW, trialNumber) {
		var p = null;
		var c = null;
		var defeat = false;
		switch(pW) {
		case "가위": p = 0; break;
		case "바위": p = 1; break;
		case "보": p = 2; break;
		}

		switch(cW) {
		case "가위": c = 0; break;
		case "바위": c = 1; break;
		case "보": c = 2; break;
		}

		if (c == p) {
			alert("비겼어요!");
			weaponDisabled = true;
			document.getElementById("cW"+trialNumber).style.background = "url('./img/broken.png') no-repeat";
			return weaponDisabled;
			
		} else if( (p + 1) % 3 == c) {
			alert("졌어요!");
			document.getElementById("cv"+trialNumber).style.display = "block";
			document.getElementById("cv"+trialNumber).style.background = "url('./img/winner.png') no-repeat";
			document.getElementById("cv"+trialNumber).value = "V";
			weaponDisabled = true;
			return weaponDisabled;
		} else {
			alert("이겼어요!");
			document.getElementById("pv"+trialNumber).style.display = "block";
			document.getElementById("pv"+trialNumber).style.background = "url('./img/winner.png') no-repeat";
			document.getElementById("pv"+trialNumber).value = "V";
			document.getElementById("cW"+trialNumber).style.background = "url('./img/broken.png') no-repeat";
			
		}
	}
	// 5판 3선승 제
	
	
	// 클릭시 weapon
	function attackButtonClick() {
		var spw = document.getElementById("selectedPlayerWeapon");
		var scw = document.getElementById("selectedComWeapon");
		for (var i = 1; i < 6; i++) {
			var btn = document.getElementById("pW" + i);
			btn.addEventListener("click", function() {
				this.value;
				spw.value = this.value;
				scw.value = document.getElementById("cW" + attackButtonClick.count).value;
				changeSelectedPlayerWeapon(spw.value);
				changeSelectedComWeapon(scw.value);
				if (judge(spw.value, scw.value, attackButtonClick.count) == true){
					this.style.background = "url('./img/broken.png') no-repeat";
					this.style.border = "none";
					this.disabled=true;
				}
				attackButtonClick.count++;
				
				// referee 호출(결과화면)
				if(attackButtonClick.count == 6) {
					referee();
					showPopup();
					//레이아웃 만드는 역할
						// 결과화면 컨텐츠 호출
				}
			}); 
		}
		
	}
	
	function changeSelectedPlayerWeapon(value) { 
		var weaponStyle = document.getElementById("selectedPlayerWeapon").style;
		switch (value) {
		case "가위":
			weaponStyle.background = "url('./img/selectedScissorButton.png') no-repeat";
			break;
		case "바위":
			weaponStyle.background = "url('./img/selectedRockButton.png') no-repeat";
			break;
		case "보":
			weaponStyle.background = "url('./img/selectedPaperButton.png') no-repeat";
			break;
		}
	}
	
	function changeSelectedComWeapon(value) { 
		var weaponStyle = document.getElementById("selectedComWeapon").style;
		switch (value) {
		case "가위":
			weaponStyle.background = "url('./img/selectedScissorButton.png') no-repeat";
			break;
		case "바위":
			weaponStyle.background = "url('./img/selectedRockButton.png') no-repeat";
			break;
		case "보":
			weaponStyle.background = "url('./img/selectedPaperButton.png') no-repeat";
			break;
		}
	}
	
	
	//결과화면 컨텐츠 구성
	function referee() {
		
		var victoryNumber = 0;
		var defeatNumber = 0;
		var drawNumber = 0;
		for(var i = 1;i < 6;i++) {
			if (document.getElementById("pv"+i).value == "V") {
				victoryNumber++;
			}
			if (document.getElementById("cv"+i).value == "V") {
				defeatNumber++;
			}
		} 
		drawNumber = 5 - (victoryNumber + defeatNumber);
		
		document.getElementById("vicNumber").innerHTML = victoryNumber;
		document.getElementById("defeatNumber").innerHTML = defeatNumber;
		document.getElementById("drawNumber").innerHTML = drawNumber;
		
		if (victoryNumber > defeatNumber) {
			document.getElementById("resultHead").innerHTML = "축하합니다! 승리하셨습니다!!";
		} else if (defeatNumber > victoryNumber) {
			document.getElementById("resultHead").innerHTML = "안타깝네요.. 패배하셨습니다ㅠㅠ";
		} else {
			document.getElementById("resultHead").innerHTML = "비겼습니다!! 다시 도전해보세요!";
		}
		
		

	}


	function setOverlay() {
		///Get screen dimesions

		///Set dimensions of background div
		document.getElementById('fade').style.width = "100%";
		document.getElementById('fade').style.height = "100%";
	}

	///Show popup
	function showPopup() {
		setOverlay();

		///Display popup and background divs
		document.getElementById("gameResult").style.display = 'block';
		document.getElementById("fade").style.display = 'block';
	}

	///Close popup
	function closeButtonClick() {
		var btn = document.getElementById("close");
		btn.addEventListener("click", function() {window.close(); });
	}
	
	function restartButtonClick() {
		var btn = document.getElementById("restart");
		btn.addEventListener("click", function() {location.reload(); });
	}
	
	
	
	
	
	
	// 프로토타입 객체 확장
	Array.prototype.shuffle = function(){ 
		 if(this instanceof Array) {
			 var len = this.length;
				if(len == 1) return this;
			 var i = len * 2;
		  while(i > 0) {
		   var idx1 = Math.floor(Math.random()* len);
		   var idx2 = Math.floor(Math.random()* len);
		   if(idx1 == idx2) continue;
		   var temp = this[idx1];
		   this[idx1] = this[idx2];
		   this[idx2] = temp;
		   i--;
		   }
		 } else {
		  alert("No Array Object");
		  } 
		 	return this;
	}
	

	