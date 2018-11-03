function changeImg(imageName, imageSrc){
  var el = document.getElementById(imageName);
  el.src = imageSrc;
  el.onerror = function() {
    el.src = 'images/noImage.gif';
  }
}

function alterImage(elem, img){
  elem.onerror = null;
  elem.src = img;
}
