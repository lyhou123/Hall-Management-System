public class ClassUI {
    public static void Welcome() {
        System.out.println("\n" +
                " __                  __  __        __                            __        __                           \n" +
                "/  |                /  |/  |      /  |                          /  |      /  |                          \n" +
                "$$ |____    ______  $$ |$$ |      $$ |____    ______    ______  $$ |   __ $$/  _______    ______        \n" +
                "$$      \\  /      \\ $$ |$$ |      $$      \\  /      \\  /      \\ $$ |  /  |/  |/       \\  /      \\       \n" +
                "$$$$$$$  | $$$$$$  |$$ |$$ |      $$$$$$$  |/$$$$$$  |/$$$$$$  |$$ |_/$$/ $$ |$$$$$$$  |/$$$$$$  |      \n" +
                "$$ |  $$ | /    $$ |$$ |$$ |      $$ |  $$ |$$ |  $$ |$$ |  $$ |$$   $$<  $$ |$$ |  $$ |$$ |  $$ |      \n" +
                "$$ |  $$ |/$$$$$$$ |$$ |$$ |      $$ |__$$ |$$ \\__$$ |$$ \\__$$ |$$$$$$  \\ $$ |$$ |  $$ |$$ \\__$$ |      \n" +
                "$$ |  $$ |$$    $$ |$$ |$$ |      $$    $$/ $$    $$/ $$    $$/ $$ | $$  |$$ |$$ |  $$ |$$    $$ |      \n" +
                "$$/   $$/  $$$$$$$/ $$/ $$/       $$$$$$$/   $$$$$$/   $$$$$$/  $$/   $$/ $$/ $$/   $$/  $$$$$$$ |      \n" +
                "                                                                                        /  \\__$$ |      \n" +
                "                                                                                        $$    $$/       \n" +
                "                                                                                         $$$$$$/        \n");
    }
    public static void menu()
    {
        System.out.println("[[ Application Menu]]");
        System.out.println("<A> Booking Hall");
        System.out.println("<B> Hall Checking");
        System.out.println("<C> Showtime Hall");
        System.out.println("<D> Reboot Showtime Hall");
        System.out.println("<E> History Hall");
        System.out.println("<F> Exit Application");
    }
    static void showTime()
    {
        System.out.println("=".repeat(90));
        System.out.println("<<<< Start Booing Process >>>>");
        System.out.println("=".repeat(90));
        System.out.println("# A) Morning (10:00AM - 12:30PM)");
        System.out.println("# B) Afternoon (03:00PM - 5:30PM)");
        System.out.println("# C) Night (07:00PM - 09:30PM)");
        System.out.println("=".repeat(90));
    }
    static void role()
    {
        System.out.println("You can input single value: [A-1]:");
        System.out.println("You can input multiple value: [A-1,A-2]");
    }
}
