<%@page contentType="text/html" pageEncoding="UTF-8"%>

<img src="${appContextPath}/resources/upload/${post.imageName}" class="img-responsive" style="width: 100%"/>
<br />
<div class="row">
    <div class="col-md-6 text-center">
        <div class="well">Dodany przez <a href="${appContextPath}/user/${post.poster.id}">${post.poster.name}</a></div>
    </div>
    <div class="col-md-6">
        <div class="well text-center">Data dodania : ${post.dateOfPublish}</div>
    </div>
</div>
<div class="well text-justify">
    ${post.text}
</div>
