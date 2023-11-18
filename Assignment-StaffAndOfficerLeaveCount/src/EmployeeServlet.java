import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[][] employeeDetails = new String[3][7];

        for (int i = 0; i < 3; i++) {
            int id = Integer.parseInt(request.getParameter("id" + i));
            String name = request.getParameter("name" + i);
            LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth" + i));
            String email = request.getParameter("email" + i);
            LocalDate joiningDate = LocalDate.parse(request.getParameter("joiningDate" + i));
            int employeeType = Integer.parseInt(request.getParameter("employeeType" + i));

            Employee employee;
            if (employeeType == 1) {
                employee = new Officer(id, name, dateOfBirth, email, joiningDate);
            } else {
                employee = new Staff(id, name, dateOfBirth, email, joiningDate);
            }
            employeeDetails[i][0] = "ID: " + id;
            employeeDetails[i][1] = "Name: " +name;
            employeeDetails[i][2] = "Date of Birth: " +dateOfBirth;
            employeeDetails[i][3] = "Email: " + email;
            employeeDetails[i][4] = "Joining Date: " + joiningDate;
            employeeDetails[i][5] = "Vacation Leave: " + employee.calculateVacationLeave();
            employeeDetails[i][6] = "Sick Leave: " + employee.calculateSickLeave();
        }

        request.setAttribute("empDetails", employeeDetails);
        request.getRequestDispatcher("employeeDetails.jsp").forward(request, response);
    }
}

