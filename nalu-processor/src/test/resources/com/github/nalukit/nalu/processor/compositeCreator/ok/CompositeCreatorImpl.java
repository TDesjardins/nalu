package com.github.nalukit.nalu.processor.compositeCreator.ok;

import com.github.nalukit.nalu.client.Router;
import com.github.nalukit.nalu.client.component.AbstractCompositeController;
import com.github.nalukit.nalu.client.exception.RoutingInterceptionException;
import com.github.nalukit.nalu.client.internal.AbstractCompositeCreator;
import com.github.nalukit.nalu.client.internal.application.CompositeFactory;
import com.github.nalukit.nalu.client.internal.application.CompositeInstance;
import com.github.nalukit.nalu.client.internal.application.IsCompositeCreator;
import com.github.nalukit.nalu.processor.common.MockContext;
import java.lang.Object;
import java.lang.String;
import org.gwtproject.event.shared.SimpleEventBus;

/**
 * Build with Nalu version >>HEAD-SNAPSHOT<< at >>2020.08.31-11:45:58<<
 */
public final class CompositeCreatorImpl extends AbstractCompositeCreator<MockContext> implements IsCompositeCreator {
  public CompositeCreatorImpl(Router router, MockContext context, SimpleEventBus eventBus) {
    super(router, context, eventBus);
  }
  
  public CompositeInstance create(String parentControllerClassName) throws
                                                                    RoutingInterceptionException {
    CompositeInstance compositeInstance = new CompositeInstance();
    compositeInstance.setCompositeClassName("com.github.nalukit.nalu.processor.compositeCreator.ok.Composite");
    AbstractCompositeController<?, ?, ?> storedComposite = CompositeFactory.get().getCompositeFormStore(parentControllerClassName, "com.github.nalukit.nalu.processor.compositeCreator.ok.Composite");
    if (storedComposite == null) {
      Composite composite = new Composite();
      compositeInstance.setComposite(composite);
      composite.setParentClassName(parentControllerClassName);
      composite.setCached(false);
      composite.setContext(context);
      composite.setEventBus(eventBus);
      composite.setRouter(router);
      composite.setCached(false);
      ICompositeComponent component = new CompositeComponent();
      component.setController(composite);
      composite.setComponent(component);
      component.render();
      component.bind();
    } else {
      compositeInstance.setComposite(storedComposite);
      compositeInstance.setCached(true);
      compositeInstance.getComposite().setCached(true);
    }
    return compositeInstance;
  }
  
  public void setParameter(Object object, String... params) throws RoutingInterceptionException {
  }
}
