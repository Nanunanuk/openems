package io.openems.edge.ess.core.power.solver;

import java.util.List;

import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.PivotSelectionRule;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import io.openems.edge.ess.core.power.data.LinearSolverUtil;
import io.openems.edge.ess.power.api.Coefficients;

public class LinearConstraintsSolver {

	/**
	 * Solves the problem with the given list of LinearConstraints.
	 * 
	 * @param constraints a list of LinearConstraints
	 * @return a solution
	 * @throws MathIllegalStateException if not solvable
	 */
	public static PointValuePair solve(Coefficients coefficients, List<LinearConstraint> constraints)
			throws MathIllegalStateException {
		LinearObjectiveFunction objectiveFunction = LinearSolverUtil
				.getDefaultObjectiveFunction(coefficients.getNoOfCoefficients());

		SimplexSolver solver = new SimplexSolver();
		return solver.optimize(//
				objectiveFunction, //
				new LinearConstraintSet(constraints), //
				GoalType.MINIMIZE, //
				PivotSelectionRule.BLAND);
	}

}
