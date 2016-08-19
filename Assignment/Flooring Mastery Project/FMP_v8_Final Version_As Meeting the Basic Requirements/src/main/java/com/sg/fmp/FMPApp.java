/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Features:
1. Refresh the page
2. Formatted Display with special characters units
3. Using Hashmap<String, Order>, which is single Hashmap data structure, faster for calculation and big O
4. Only retrieve data from database into memory when there is a need, reduce memory reading as much as possible
5. Using production controller to extends the test controller to save code (inherit all codes from test mode, and add more codes particular for production controller)
6. Freely switching mode within the system, also can quit system immediately in any mode (Used to have infinite instance problem, but solved)
7. Store the data in separate foler, using foler path to find database
8. Add snapshot feature to the settings, user can view, create, and restore data
9. Dynamically display snapshot menu (vary when snapshot list changed)
*/
package com.sg.fmp;

import com.sg.fmp.operation.FMPLauncher;

/**
 *
 * @author Kratos
 */
public class FMPApp {
    public static void main(String[] args) {
        FMPLauncher launcher = new FMPLauncher();
        launcher.execute();
    }
}
