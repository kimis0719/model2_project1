<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <script>
        const add_textbox = () => {
            const box = document.getElementById("box");
            const newP = document.createElement('p');
            newP.innerHTML = "<input type='text'> <input type='button' value='삭제' onclick='remove(this)'>";
            box.appendChild(newP);
        }
        const remove = (obj) => {
            document.getElementById('box').removeChild(obj.parentNode);
        }
    </script>
</head>
<body>
    <form>
        <div id="box">
            <input type="text"> <input type="button" value="추가" onclick="add_textbox()">
        </div>
    </form>
</body>
</html>