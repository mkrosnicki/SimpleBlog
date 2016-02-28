<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<br />
<br />

<!-- CONTENT -->
<div class="col-md-1"></div>

<div class="col-md-10">

    <div class="well">

        <form method="POST" enctype="multipart/form-data">
            <label class="control-label">Select File</label>
            <input id="input-form" name="input6[]" type="file" multiple class="file-loading" data-allowed-file-extensions='["jpg", "jpeg"]'>
        </form>



    </div>
</div>

<div class="col-md-1"></div>