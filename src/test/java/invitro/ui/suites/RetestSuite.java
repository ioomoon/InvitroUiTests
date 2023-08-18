package invitro.ui.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@SelectPackages("invitro.ui.tests")
@IncludeTags("Bug")
@Suite
public class RetestSuite {
}
