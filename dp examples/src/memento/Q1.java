package memento;

import java.util.Stack;

class EditorSnapshot {

    private final String code;

    public EditorSnapshot(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

class Editor {

    private String code = "";

    public void write(String text) {
        code += text;
    }

    public EditorSnapshot save() {
        return new EditorSnapshot(code);
    }

    public void restore(EditorSnapshot editorSnapshot) {
        code = editorSnapshot.getCode();
    }

    public String getCode() {
        return code;
    }
}

class HistoryManager {

    private Stack<EditorSnapshot> undoSnap = new Stack<>();
    private Stack<EditorSnapshot> redoSnap = new Stack<>();

    public void saveState(Editor editor) {
        undoSnap.push(editor.save());
        redoSnap.clear();
    }

    public void redo(Editor editor) {
        if (!redoSnap.empty()) {
            undoSnap.push(editor.save());
            editor.restore(redoSnap.pop());
        }
    }

    public void undo(Editor editor) {
        if (!undoSnap.empty()) {
            redoSnap.push(editor.save());
            editor.restore(undoSnap.pop());
        }
    }
}

public class Q1 {

    public static void main(String[] args) {

        Editor editor = new Editor();
        HistoryManager history = new HistoryManager();

        editor.write("Hello");
        history.saveState(editor);

        editor.write(" world.");
        history.saveState(editor);

        System.out.println("Output: " + editor.getCode());

        history.undo(editor);
        System.out.println("1st undo: " + editor.getCode());

        history.undo(editor);
        System.out.println("2st undo: " + editor.getCode());

        history.redo(editor);
        System.out.println("1st wdo: " + editor.getCode());

    }
}
