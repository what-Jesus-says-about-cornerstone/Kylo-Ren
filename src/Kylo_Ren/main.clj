(ns Kylo-Ren.main
  (:gen-class)
  (:require
   [clojure.core.async
    :refer [chan go go-loop <! >! <!! >!!  take! put! offer! poll! alt! alts! close! onto-chan!
            pub sub unsub mult tap untap mix admix unmix pipe
            timeout to-chan  sliding-buffer dropping-buffer
            pipeline pipeline-async]]
   [clojure.string]
   [clojure.java.io]

   [Kylo-Ren.lychee])
  (:import
   (javax.swing JFrame WindowConstants JPanel JScrollPane JTextArea BoxLayout JEditorPane ScrollPaneConstants SwingUtilities JDialog)
   (javax.swing JMenu JMenuItem JMenuBar KeyStroke JOptionPane JToolBar JButton JToggleButton JSplitPane JLabel JTextPane JTextField JTable JTabbedPane)
   (javax.swing DefaultListSelectionModel JCheckBox UIManager)
   (javax.swing.border EmptyBorder)
   (java.awt Canvas Graphics Graphics2D Shape Color Polygon Dimension BasicStroke Toolkit Insets BorderLayout)
   (java.awt.event KeyListener KeyEvent MouseListener MouseEvent ActionListener ActionEvent ComponentListener ComponentEvent)
   (java.awt.event  WindowListener WindowAdapter WindowEvent)
   (com.formdev.flatlaf FlatLaf FlatLightLaf)
   (com.formdev.flatlaf.extras FlatUIDefaultsInspector FlatDesktop FlatDesktop$QuitResponse)
   (com.formdev.flatlaf.util SystemInfo UIScale)
   (java.util.function Consumer)
   (java.util ServiceLoader)
   (net.miginfocom.swing MigLayout)
   (net.miginfocom.layout ConstraintParser LC UnitValue)
   (java.io File)
   (java.lang Runnable)
   (java.nio.charset StandardCharsets)))

(def ^String jframe-title "you know I can take whatever I want")
(def stateA (atom {}))

(defn -main
  [& args]
  (println "you know I can take whatever I want")

  (when SystemInfo/isMacOS
    (System/setProperty "apple.laf.useScreenMenuBar" "true")
    (System/setProperty "apple.awt.application.name" jframe-title)
    (System/setProperty "apple.awt.application.appearance" "system"))

  (when SystemInfo/isLinux
    (JFrame/setDefaultLookAndFeelDecorated true)
    (JDialog/setDefaultLookAndFeelDecorated true))

  (when (and
         (not SystemInfo/isJava_9_orLater)
         (= (System/getProperty "flatlaf.uiScale") nil))
    (System/setProperty "flatlaf.uiScale" "2x"))

  (FlatLightLaf/setup)

  (let [jframe (JFrame. jframe-title)]

    (doto jframe
      (.setPreferredSize (let [size (-> (Toolkit/getDefaultToolkit) (.getScreenSize))]
                           (Dimension. (* 0.7 (.getWidth size)) (* 0.7 (.getHeight size)))))
      (.setDefaultCloseOperation WindowConstants/DISPOSE_ON_CLOSE)
      (.pack)
      (.setLocationRelativeTo nil)
      (.setVisible true)))

  nil)