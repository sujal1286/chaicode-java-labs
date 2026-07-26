package com.chaicode.variables;

import com.chaicode.variables.model.EmployeeProfile;

/**
 * TechCorp Employee Badge Printer
 *
 * <p>HR needs a badge formatter for the new hire orientation. Given an employee profile,
 * build the badge text printed on their lanyard.
 *
 * <p>Format (exactly):
 * <pre>
 * [ID-00042] Priya Sharma | Engineering | MANAGER
 * </pre>
 *
 * <p>Rules:
 * <ul>
 *   <li>ID is zero-padded to 5 digits (e.g. employeeId 42 → "00042")</li>
 *   <li>If isManager is true, suffix is "MANAGER"; otherwise "STAFF"</li>
 *   <li>department is used as-is (already validated)</li>
 * </ul>
 *
 * @param profile the employee profile
 * @return formatted badge string
 */


public  class EmployeeBadge {

    public static void main(String[] args) {

        EmployeeProfile p1 = new EmployeeProfile("Priya Sharma", 42, "Engineering", true);
        EmployeeProfile p2 = new EmployeeProfile("Ravi Mehta", 7, "Design", false);

        System.out.println(formatBadge(p1));
        System.out.println(formatBadge(p2));
    }

    public static String formatBadge(EmployeeProfile profile) {

        String paddedId = String.format("%05d", profile.employeeId());

        String role;
        if (profile.isManager()) {
            role = "MANAGER";
        } else {
            role = "STAFF";
        }

        return "[ID-" + paddedId + "] " + profile.name() + " | " + profile.department() + " | " + role;
    }
}
