<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>댓글 상세 정보</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px 0;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            width: 150px;
        }
    </style>
</head>
<body>
    <h1>댓글 상세 보기</h1>
    
    <c:choose>
        <%-- comment 객체가 존재할 경우 --%>
        <c:when test="${not empty comment}">
            <table>
                <tr>
                    <th>댓글 번호 (comment_no)</th>
                    <td>${comment.commentNo}</td>
                </tr>
                <tr>
                    <th>작성자 ID (user_id)</th>
                    <td>${comment.userId}</td>
                </tr>
                <tr>
                    <th>등록 날짜 (reg_date)</th>
                    <%-- java.util.Date 타입을 원하는 형식으로 출력 --%>
                    <td><fmt:formatDate value="${comment.regDate}" pattern="yyyy년 MM월 dd일 HH:mm:ss"/></td>
                </tr>
                <tr>
                    <th>댓글 내용 (comment_content)</th>
                    <td>${comment.commentContent}</td>
                </tr>
            </table>
        </c:when>
        <%-- comment 객체가 없을 경우 --%>
        <c:otherwise>
            <p>조회된 댓글 정보가 없습니다.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>