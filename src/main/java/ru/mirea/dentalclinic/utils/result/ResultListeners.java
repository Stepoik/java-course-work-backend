package ru.mirea.dentalclinic.utils.result;

@FunctionalInterface
interface OnFailureListener {
    void onFailure(Throwable throwable);
}

@FunctionalInterface
interface OnSuccessListener<T> {
    void onSuccess(T value);
}
