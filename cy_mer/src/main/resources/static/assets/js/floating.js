(function(b,a){a(b)})(typeof this.window!=="undefined"?window:this,function(j){var b,f,a,m,k=0,l=0,g=0,d=0,c=1,e=10,i=0,h=0;var n=function(){a=document.body.clientWidth,m=document.body.clientHeight,i=f.offsetWidth;h=f.offsetHeight;if(l){d+=c}else{d-=c}if(d<0){l=1;d=0}if(d>=(m-h)){l=0;d=(m-h)}if(k){g+=c}else{g-=c}if(g<0){k=1;g=0}if(g>=(a-i)){k=0;g=(a-i)}f.style.left=g+"px";f.style.top=d+"px"};(function(){var p=document.currentScript;if(!p&&document.querySelector){p=document.querySelector("script[data-float-id]")}if(!p){var o=document.scripts;for(var q=0,r;r=o[q++];){if(r.readyState=="interactive"){p=r;continue}}}f=p.parentNode;if(f){g=f.offsetLeft;d=f.offsetTop;f.style.position="absolute";b=setInterval(n,e)}})()});