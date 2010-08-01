package org.freeplane.plugin.script.proxy;

import org.freeplane.core.controller.Controller;
import org.freeplane.features.mindmapmode.MModeController;

public abstract class AbstractProxy<T> {
	final private T delegate;
// 	final private MModeController modeController;

	AbstractProxy(final T delegate) {
		this.delegate = delegate;
	}

	@SuppressWarnings("unchecked")
    @Override
	public boolean equals(final Object obj) {
		if (!getClass().equals(obj.getClass())) {
			return false;
		}
		return delegate.equals(((AbstractProxy) obj).getDelegate());
	}

	public T getDelegate() {
		return delegate;
	}

	public MModeController getModeController() {
		return (MModeController) Controller.getCurrentModeController();
	}

	@Override
	public int hashCode() {
		return delegate.hashCode() * 31 + getClass().hashCode();
	}

	@Override
    public String toString() {
	    return getClass() + ":" + delegate.toString();
    }
}
