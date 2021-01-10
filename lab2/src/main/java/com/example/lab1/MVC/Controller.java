package com.example.lab1.MVC;

public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }


    public void processUser() {
        model.createServiceSystem();
        view.printMessage(View.QUEUE1 + View.MAXIMUM_QUEUE_LENGTH + model.maximumQueuelength(model.getProcess1()));
        view.printMessage(View.QUEUE2 + View.MAXIMUM_QUEUE_LENGTH + model.maximumQueuelength(model.getProcess2()));
        view.printMessage(model.getCpu1().getName() + View.PROCESSED_REQUESTS + model.getProcessedTasks(model.getCpu1()));
        view.printMessage(model.getCpu2().getName() + View.PROCESSED_REQUESTS + model.getProcessedTasks(model.getCpu2()));
        view.printMessage(model.getCpu3().getName() + View.PROCESSED_REQUESTS + model.getProcessedTasks(model.getCpu3()));
        view.printMessage(model.getCpu3().getName() + View.TAKEN + View.QUEUE1 + model.calculateShare(model.getProcess1(),
                model.getCpu1()) + "%");
        view.printMessage(model.getCpu3().getName() + View.TAKEN + View.QUEUE2 + model.calculateShare(model.getProcess2(),
                model.getCpu2()) + "%");
    }
}
