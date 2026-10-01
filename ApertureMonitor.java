import javax.swing.*;import java.awt.*;import java.io.File;import java.lang.management.*;
/* <ars> */
public class ApertureMonitor extends JFrame {
    private JTextArea consoleArea;
    public ApertureMonitor() {
        setTitle("Aperture Science System Monitor v1.0");setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);setLocationRelativeTo(null);setResizable(false);
        consoleArea = new JTextArea();consoleArea.setBackground(Color.BLACK);
        consoleArea.setForeground(new Color(0, 255, 0)); // Имитация команды color 2 (Ярко-зеленый)
        consoleArea.setFont(new Font("Consolas", Font.PLAIN, 14));consoleArea.setEditable(false);
        consoleArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(new JScrollPane(consoleArea));
        new Timer(1000, e -> updateStats()).start();updateStats();
    }
    private void updateStats() {
        StringBuilder sb = new StringBuilder();
        sb.append("Microsoft Windows [Version 10.0.19045]\n(c) Корпорация Майкрософт. Все права защищены.\n\n");
        sb.append("C:\\Aperture\\System\\Core> monitor_system.exe -run\n");
        sb.append("==================================================\n");
        sb.append(" APERTURE LABS SYSTEM MONITOR CORE v1.0\n");
        sb.append("==================================================\n\n");
        OperatingSystemMXBean os = ManagementFactory.getOperatingSystemMXBean();
        sb.append(" ОС Архитектура:  ").append(os.getArch()).append("\n");
        sb.append(" Процессоры (Ядра): ").append(os.getAvailableProcessors()).append(" units\n");
        Runtime rt = Runtime.getRuntime();long maxMem = rt.maxMemory()/(1024*1024);long allocMem = rt.totalMemory()/(1024*1024);
        long freeMem = rt.freeMemory()/(1024*1024);long usedMem = allocMem - freeMem;
        sb.append(" Память JVM (Занято): ").append(usedMem).append(" MB / ").append(maxMem).append(" MB\n");
        File cDrive = new File("C:");long cTotal = cDrive.getTotalSpace()/(1024*1024*1024);long cFree = cDrive.getFreeSpace()/(1024*1024*1024);
        long cUsed = cTotal - cFree;
        sb.append(" Диск C: (Занято):  ").append(cUsed).append(" GB / ").append(cTotal).append(" GB\n");
        sb.append(" Диск C: (Свободно): ").append(cFree).append(" GB\n\n");
        sb.append(" Статус GLaDOS:     ACTIVE [ONLINE]\n");
        sb.append("==================================================\n");
        sb.append("Обновление данных через 1 сек...");
        consoleArea.setText(sb.toString());
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new ApertureMonitor().setVisible(true)); }
}
/* </ars> */
