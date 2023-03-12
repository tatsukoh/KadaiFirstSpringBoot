package com.techacademy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{day}")
    public String dispDayOfWeek(@PathVariable String day) {
        try {
            // 日付チェック
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            sdf.setLenient(false);
            sdf.parse(day);

            // 年・月を取得する
            int y = Integer.parseInt(day.substring(0, 4));
            int m = Integer.parseInt(day.substring(4, 6)) - 1;
            int d = Integer.parseInt(day.substring(6, 8));

            // 取得した年月の最終年月日を取得する
            Calendar cal = Calendar.getInstance();
            cal.set(y, m, d);

            // 曜日を得る
            switch (cal.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:
                return "Sunday";
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.SATURDAY:
                return "Saturday";
            }

            return "曜日が判断できませんでした";

        } catch (ParseException e) {
            e.printStackTrace();
            return "日付は「yyyymmdd」形式で入力してください";
        }
    }

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "計算結果：" + res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "計算結果：" + res;
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "計算結果：" + res;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable float val1, @PathVariable float val2) {
        float res = 0;
        res = val1 / val2;
        return "計算結果：" + res;
    }
}
