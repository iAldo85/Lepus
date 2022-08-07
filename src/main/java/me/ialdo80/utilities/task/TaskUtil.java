package me.ialdo80.utilities.task;

import me.ialdo80.Lepus;
import lombok.experimental.UtilityClass;
import org.bukkit.scheduler.BukkitRunnable;

@UtilityClass
public class TaskUtil {

    public void run(Runnable runnable) {
        Lepus.get().getServer().getScheduler().runTask(Lepus.get(), runnable);
    }

    public void runTimer(Runnable runnable, long delay, long timer) {
        Lepus.get().getServer().getScheduler().runTaskTimer(Lepus.get(), runnable, delay, timer);
    }

    public void runTimer(BukkitRunnable runnable, long delay, long timer) {
        runnable.runTaskTimer(Lepus.get(), delay, timer);
    }

    public void runTimerAsync(Runnable runnable, long delay, long timer) {
        Lepus.get().getServer().getScheduler().runTaskTimerAsynchronously(Lepus.get(), runnable, delay, timer);
    }

    public void runTimerAsync(BukkitRunnable runnable, long delay, long timer) {
        runnable.runTaskTimerAsynchronously(Lepus.get(), delay, timer);
    }

    public void runLater(Runnable runnable, long delay) {
        Lepus.get().getServer().getScheduler().runTaskLater(Lepus.get(), runnable, delay);
    }

    public void runLaterAsync(Runnable runnable, long delay) {
        try {
            Lepus.get().getServer().getScheduler().runTaskLaterAsynchronously(Lepus.get(), runnable, delay);
        } catch (IllegalStateException e) {
            Lepus.get().getServer().getScheduler().runTaskLater(Lepus.get(), runnable, delay);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void runTaskTimerAsynchronously(Runnable runnable, int delay) {
        try {
            Lepus.get().getServer().getScheduler().runTaskTimerAsynchronously(Lepus.get(), runnable, 20L * delay, 20L * delay);
        } catch (IllegalStateException e) {
            Lepus.get().getServer().getScheduler().runTaskTimer(Lepus.get(), runnable, 20L * delay, 20L * delay);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void runAsync(Runnable runnable) {
        try {
            Lepus.get().getServer().getScheduler().runTaskAsynchronously(Lepus.get(), runnable);
        } catch (IllegalStateException e) {
            Lepus.get().getServer().getScheduler().runTask(Lepus.get(), runnable);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}