/*
let navigationBox = {
	
	_onWindowLoad : function(){
		let navigation = document.querySelector("#navigation");
		let ul = navigation.childNodes[1];
	
		let liLinks = ul.getElementsByTagName("a");
		for(let i = 0; i < liLinks.length; i++) {
			liLinks[i].addEventListener("click", this._onTabClicked);
		}
	},
	
	_onTabClicked : function(event){
		event.preventDefault();
		//unselected
		let lisSelected = document.querySelectorAll(".selected");
		(lisSelected.length === 1) && (lisSelected[0].className = "");
	
		// select
		this.parentNode.className='selected';
	},
	
	
	init : function(){
		window.addEventListener('load', this._onWindowLoad.bind(this));
	}
	
}

navigationBox.init();
*/


