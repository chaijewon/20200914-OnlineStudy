<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="best-features">
      <div style="height:130px"></div>
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="section-heading">
              <h2>${vo.title }</h2>
            </div>
          </div>
          <div class="col-md-6">
            <div class="left-content">
              <h4>${vo.title}</h4>
              <p><i>"${vo.content }"</i></p>
              <span>요리법</span>
              <ul class="featured-list">
                <c:forEach var="s" items="${vo.mList }">
                  <li style="font-size:8pt">${s }</li>
                </c:forEach>
                
              </ul>
              <span class="filled-button">
               <table class="table">
                <tr>
                 <td class="text-center">${vo.info1 }</td>
                 <td class="text-center">${vo.info2 }</td>
                 <td class="text-center">${vo.info3 }</td>
                </tr>
               </table>
            </div>
          </div>
          <div class="col-md-6">
            <div class="right-image">
              <img src="${vo.poster }" alt="">
            </div>
          </div>
        </div>
      </div>
    </div>


    <div class="call-to-action">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="inner-content">
              <div class="row">
                <div class="col-md-8">
                  <h4><em>${vo.chef }</em></h4>
                  <p>${vo.chef_profile }</p>
                </div>
                <div class="col-md-4">
                  <img src="${vo.chef_poster }">
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</body>
</html>