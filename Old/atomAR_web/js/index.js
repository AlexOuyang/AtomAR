var lettering = function(element) {
  var text = element.innerHTML;
  var size = window.getComputedStyle(element).getPropertyValue("font-size").substring(0, 2);
  if (element.classList.contains('fallback'));
  if (element.parentNode.getAttribute('aria-hidden') === null) {
    var clone = element.cloneNode(true);

    clone.classList.add('fallback');

    element.setAttribute('aria-hidden', 'true');

    clone.classList.add('hide');

    element.parentNode.insertBefore(clone, element.nextSibling);
  }
  element.innerHTML = "";
  for (var i = 0; i < text.length; i++) {
    var span = document.createElement("span");
    span.innerHTML = text[i];
    if (text[i] == " ") {
      span.style.margin = "0 " + (size / 10) + "px";
    }
    span.classList.add("char" + (i + 1));
    element.appendChild(span);

  }
};

var h1 = document.querySelector("header h1");

lettering(h1);

var ring = document.querySelector("path#ring"),
  path = "",
  base = document.querySelector('circle#base'),
  second = document.querySelector('path#second'),
  third = document.querySelector('path#third');

base.setAttribute('cx', 80);
base.setAttribute('cy', 135);
base.setAttribute('r', 35);

path = "M45,145 c-50,-10 -60,-40 10,-35 c95,8 150,50 51,46";

ring.setAttribute('d', path);
second.setAttribute('d', path);
third.setAttribute('d', path);

var animate = function() {
  ring.classList.add('animate');
  second.classList.add('animate');
  third.classList.add('animate');
};

h1.onload = animate();

setTimeout(function() {
  animate();
}, 10000);