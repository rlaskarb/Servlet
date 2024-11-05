<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator-practice</title>
</head>
<body>
   <h1>이거 왜 만든다고 했을까?</h1>

   <h1>나 계산기야 </h1>
   <form action="/menu/order" method="get">
       <label for="number1">첫번째 숫자 :</label>
       <input type="number" id="number1" name="number1" required>
       <br><br>
       <label for="operator">연산자 :</label>
       <select id="operator" name="operator">
           <option value="+">+</option>
           <option value="-">-</option>
           <option value="*">*</option>
           <option value="/">/</option>
       </select><br><br>
       <label for="number2">두번째 숫자 :</label>
       <input type="number"  id="number2"  name="number2" required><br><br>
       <button type="submit">계산 하기</button>
   </form>


</body>
</html>