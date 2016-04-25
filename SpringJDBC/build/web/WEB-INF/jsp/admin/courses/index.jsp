<%@include file="../header.jsp" %>
<%@include file="../navbar.jsp" %>
        <h1>Courses</h1>
        <div class="pull-right">
            <p>
                <a href="${SITE_URL}/admin/courses/add" class="btn-primary btn-sm" title="Add Course">
                       <span class="glyphicon glyphicon-plus"></span> 
                </a>
            </p>
        </div>
        <table class="table table-bordered table-hover table-striped">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Fees</th>
                <th>Duration</th>
                <th>Added Date</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.id}</td>
                    <td>${course.courseName}</td>
                    <td>${course.courseDescription}</td>
                    <td>${course.fees}</td>
                    <td>${course.duration} ${course.durationType}</td>
                    <td>${course.addedDate}</td>
                    <td>${course.status}</td>
                    <td>
                        <a href="${SITE_URL}/admin/courses/edit/${course.id}" class="btn-success btn-sm" title="Edit Course">
                           <span class="glyphicon glyphicon-pencil"></span> 
                        </a>
                           &nbsp;
                           <a href="${SITE_URL}/admin/courses/delete/${course.id}"  class="btn-danger btn-sm" title="Delete Course" 
                              onclick="return confirm('Are you sure want to delete this record?')">
                              
                              
                           <span class="glyphicon glyphicon-trash"></span> 
                           </a>
                           

                    
                    </td>
                    
                </tr>
            </c:forEach>
        </table>
    
<%@include file="../footer.jsp" %>