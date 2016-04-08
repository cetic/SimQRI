package be.cetic.simqri.menu.handlers;

import org.eclipse.core.commands.AbstractHandler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import be.cetic.simqri.menu.views.SimulationDialog;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class MenuHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public MenuHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		/*MessageDialog.openInformation(
		window.getShell(),
		"Simulation",
		"One Shot ? Monte-Carlo ? who pays the piper calls the tune !");*/
		SimulationDialog simDialog = new SimulationDialog(window.getShell());
		simDialog.create();
		simDialog.open();
		return null;
	}
}
