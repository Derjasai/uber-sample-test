import { NavigateFunction, NavigateOptions } from 'react-router-dom';

export enum FinanceRoutes {
    FOLLOW_RIDE = 'FOLLOW_RIDE',
    START_RIDE = 'START_RIDE',
}

export const financeRoutesSpecification = {
    [FinanceRoutes.FOLLOW_RIDE]: {
        reactRouterPath: '/follow-ride',
        buildRoute: (params: {}) => '/follow-ride',
        buildState: () => { },
    },
    [FinanceRoutes.START_RIDE]: {
        reactRouterPath: '/',
        buildRoute: () => '/',
        buildState: () => { },
    },
};

type FinanceNavigateOptions<T> = T extends undefined ? Omit<NavigateOptions, 'state'> : Omit<NavigateOptions, 'state'> & { state: T };

type NavigationProps = {
    [EnumKey in FinanceRoutes]: Parameters<(typeof financeRoutesSpecification)[EnumKey]['buildRoute']>[0] extends undefined
    ? Parameters<(typeof financeRoutesSpecification)[EnumKey]['buildState']>[0] extends undefined
    ? {
        options?: FinanceNavigateOptions<Parameters<(typeof financeRoutesSpecification)[EnumKey]['buildState']>[0]>;
        navigate: NavigateFunction;
    }
    : {
        options: FinanceNavigateOptions<Parameters<(typeof financeRoutesSpecification)[EnumKey]['buildState']>[0]>;
        navigate: NavigateFunction;
    }
    : Parameters<(typeof financeRoutesSpecification)[EnumKey]['buildState']>[0] extends undefined
    ? {
        params: Parameters<(typeof financeRoutesSpecification)[EnumKey]['buildRoute']>[0];
        options?: FinanceNavigateOptions<Parameters<(typeof financeRoutesSpecification)[EnumKey]['buildState']>[0]>;
        navigate: NavigateFunction;
    }
    : {
        params: Parameters<(typeof financeRoutesSpecification)[EnumKey]['buildRoute']>[0];
        options: FinanceNavigateOptions<Parameters<(typeof financeRoutesSpecification)[EnumKey]['buildState']>[0]>;
        navigate: NavigateFunction;
    };
};

export function financeNavigate<T extends FinanceRoutes>(route: T, props: NavigationProps[T], search?: string) {
    let pathname =
        'params' in props
            ? financeRoutesSpecification[route].buildRoute(props.params as any)
            : (financeRoutesSpecification[route].buildRoute as any)();

    if (search) {
        props.navigate(
            {
                pathname: pathname,
                search: search,
            },
            props.options
        );
    } else {
        props.navigate({ pathname: pathname }, props.options);
    }
}
