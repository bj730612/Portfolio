<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
.als-container {
	position: relative;
	width: 100%;
	margin: 0px auto;
	z-index: 0;
}
.als-viewport {
	position: relative;
	overflow: hidden;
	margin: 0px auto;
}
.als-wrapper {
	position: relative;
	/* if you are using a list with <ul> <li> */
	list-style: none;
}
.als-item {
	position: relative;
	display: block;
	text-align: center;
	cursor: pointer;
	float: left;
}
.als-prev, .als-next {
	position: absolute;
	cursor: pointer;
	clear: both;
}
</style>
</head>
<body>

<div class="als-container" id="demo4">
  <span class="als-prev"><img src="images/thin_left_arrow_333.png" alt="prev" title="previous" /></span>
  <div class="als-viewport">
    <ul class="als-wrapper">
      <li class="als-item"><img src="images/fruits/arancio.png" alt="orange" title="orange" />orange</li>
      <li class="als-item"><img src="images/fruits/mela.png" alt="apple" title="apple" />apple</li>
      <li class="als-item"><img src="images/fruits/banana.png" alt="banana" title="banana" />banana</li>
      <li class="als-item"><img src="images/fruits/mirtillo.png" alt="blueberry" title="blueberry" />blueberry</li>
      <li class="als-item"><img src="images/fruits/anguria.png" alt="watermelon" title="watermelon" />watermelon</li>
      <li class="als-item"><img src="images/fruits/ciliegia.png" alt="cherry" title="cherry" />cherry</li>
      <li class="als-item"><img src="images/fruits/fragola.png" alt="strawberry" title="strawberry" />strawberry</li>
      <li class="als-item"><img src="images/fruits/avocado.png" alt="avocado" title="avocado" />avocado</li>
      <li class="als-item"><img src="images/fruits/pera.png" alt="pear" title="pear" />pear</li>
      <li class="als-item"><img src="images/fruits/ananas.png" alt="pineapple" title="pineapple" />pineapple</li>
      <li class="als-item"><img src="images/fruits/papaya.png" alt="papaya" title="papaya" />papaya</li>
      <li class="als-item"><img src="images/fruits/lampone.png" alt="raspberry" title="raspberry" />raspberry</li>
    </ul>
  </div>
  <span class="als-next"><img src="images/thin_right_arrow_333.png" alt="next" title="next" /></span>
</div>

</body>
</html>