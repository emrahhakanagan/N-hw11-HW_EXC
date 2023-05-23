public class PasswordChecker extends RuntimeException {

    private int minLength = -1;
    private int maxRepeats = -1;

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) throws IllegalArgumentException {
        if (minLength >= 0) {
            this.minLength = minLength;
        } else {
            throw new IllegalArgumentException("Значение не должно быть меньше нуля");
        }
    }

    public int getMaxRepeats() {
        return maxRepeats;
    }

    public void setMaxRepeats(int maxRepeats) throws IllegalArgumentException {
        if (maxRepeats > 0) {
            this.maxRepeats = maxRepeats;
        } else {
            throw new IllegalArgumentException("Значение должно быть больше нуля");
        }
    }

    public boolean verify(String password) throws IllegalArgumentException {
        boolean flag;

        if (getMinLength() < 0) {
            throw new IllegalStateException("Значение мин. длины пароля не установлено!");
        } else if (getMaxRepeats() < 0) {
            throw new IllegalArgumentException("Значение макс. допустимого количества повторений символа подряд не " +
                    "установлено!");

        } else {

            int count = 0;
            for (int i = 0; i < password.length() - 1; i++) {
                if (password.charAt(i) == password.charAt(i + 1)) {
                    count++;
                } else {
                    count = 0;
                }

                if (count >= getMaxRepeats()) {
                    break;
                }
            }

            if ((count >= getMaxRepeats()) || (password.length() < getMinLength())) {
                flag = false;
            } else {
                flag = true;
            }
        }
        return flag;
    }
}
