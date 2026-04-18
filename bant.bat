@echo off
:: Обертка Beautiful Ant (bant) для Windows

ant -logger org.apache.tools.ant.listener.AnsiColorLogger %*
