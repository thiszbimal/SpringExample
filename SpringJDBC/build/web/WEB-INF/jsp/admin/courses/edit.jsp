<%@include file="../header.jsp" %>
<%@include file="../navbar.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Add Courses</h1>

<form:form modelAttribute="Course" action="${SITE_URL}/admin/courses/save" method="post" role="form">
    <div class="form-group ">
        <label>Name</label>
        <form:input path="courseName"  placeholder="Enter Course Name" required="required" class="form-control"/>
        
    </div>
    <div class="form-group">
        <label>Description</label>
        <form:textarea path="courseDescription" placeholder="Enter Course Description" required="required"  class="form-control"/>
    </div> 
    <div class="form-group">
        <label>Duration</label>
        <form:input path="duration" placeholder="Enter Duration" required="required"  class="form-control"/>
        <form:select path="durationType" required="required"  class="form-control">
            <option value="">Select Duration Type</option>
            <option value="Day">Days</option>
            <option value="Week">Weeks</option>
            <option value="Month">Months</option>
            <option value="Year">Years</option>
            </form:select>
    </div>  
    <div class="form-group">
        <label>Fees</label>
        <form:input path="fees" placeholder="Enter Fees" required="required"  class="form-control"/>
    </div> 
     <div class="checkbox">
        <label>
            <form:checkbox path="status" value="1"/> Status
        </label>
    </div>  
            <form:hidden path="id" />
            <button type="submit" class="btn btn-success">Save</button> 
            <a href="http://localhost:8080/SpringJDBC/admin/courses" class="btn btn-primary " role="button">Cancel</a>
            
</form:form>
<%@include file="../header.jsp" %>
