$(function(){
	

    		
//  		var obj = new lunbo('box');
    		
    		var box1 = document.getElementsByClassName('box1')[0];
    		var item = box1.querySelector('.item');
    		var lis = item.getElementsByTagName('li');
    		
    		var leftBtn = box1.querySelector('.leftBtn');
    		var rightBtn = box1.querySelector('.rightBtn');
    		
    		var page = box1.querySelector('.page');
    		var pages = page.getElementsByTagName('li');
    		
    		var lastLi = lis[0].cloneNode(true);
    		item.appendChild(lastLi);
//  		console.log(lastLi)
    		
    		var pageNum = 0;
    		pages[0].style.background = '#4526C8';
    		//右键点击事件
    		rightBtn.onclick=function(){
    			pageNum++;
    		    play();
    		}
    		
    		//左键点击事件
    		leftBtn.onclick = function(){
    			pageNum--;
    			play();
    		}
    		
    		//自动播放
    		var autoPlay = setInterval(function(){
    			pageNum++;
    			play();
    		},4000)
    		
    		//鼠标事件
    		box1.onmouseenter = function(){
    			clearInterval(autoPlay);
    			rightBtn.style.display = 'block';
    			leftBtn.style.display = 'block';
    		}
    		
    		box1.onmouseleave = function(){
    			rightBtn.style.display = 'none';
    			leftBtn.style.display = 'none';
    			autoPlay = setInterval(function(){
	    			pageNum++;
	    			play();
    			},4000)
    		}
    		
    		//小圆点事件
//  		console.log(pages.length);
    			for(i=0;i<pages.length;i++){
    				
    				pages[i].index = i;
    				
    				pages[i].onclick = function(){
    					this.index;
    					pageNum = this.index;
    					play();
    				}
    			}
    		//封装函数
   		
    		
    		function play(){
    			
    			if(pageNum == 4){
    				item.style.left = 0;
    				pageNum = 1;
    				
    			}
    			if(pageNum==-1){
    				//瞬间改变item的坐标
    				item.style.left = -1920*(lis.length-1) + 'px';
    				pageNum = lis.length-2;
    			}
    			animate(item,{left:-1920*pageNum}) ;
    			
    			
    			
    			for(i=0;i<pages.length;i++){
    				
    				pages[i].style.background = '#fff';
    			}
    			if(pageNum==3){
    				pages[0].style.background = '#4526C8';
    			}else{
    				pages[pageNum].style.background = '#4526c8';
    			}
    		}
    	
    	
	
	
	
	
	
	
	
	
	
	
	
})
